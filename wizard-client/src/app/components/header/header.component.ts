import {Component, DestroyRef, inject, OnInit} from '@angular/core';
import {NavigationStart, Router} from '@angular/router';
import {takeUntilDestroyed} from '@angular/core/rxjs-interop';

interface HeaderItem {
  title: string;
  url: string;
  active?: boolean;
}

@Component({
  selector: 'wizard-header',
  templateUrl: 'header.component.html',
  styleUrl: 'header.component.scss'
})
export class HeaderComponent implements OnInit {

  protected readonly HEADER_ITEMS: HeaderItem[] = [
    {
      title: 'Home',
      url: '/'
    },
    {
      title: 'New game',
      url: '/new-game'
    },
    {
      title: 'Scoreboard',
      url: '/scoreboard'
    }
  ];

  private readonly router = inject(Router);
  private readonly destroyRef = inject(DestroyRef);

  public ngOnInit(): void {
    this.router.events
      .pipe(takeUntilDestroyed(this.destroyRef))
      .subscribe(routerEvent => {
        if (routerEvent instanceof NavigationStart) {
          this.HEADER_ITEMS.forEach(headerItem => headerItem.active = routerEvent.url === headerItem.url);
        }
      });
  }

  protected async onItemSelect(url: string): Promise<void> {
    await this.router.navigate([url]);
  }

}

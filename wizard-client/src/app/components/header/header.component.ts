import { Component, EventEmitter, Output } from "@angular/core";
import { Router } from "@angular/router";

export enum HeaderElement {
  WIZARD,
  GAMES
}

@Component({
  standalone: true,
  selector: 'wizard-header',
  templateUrl: 'header.component.html',
  styleUrl: 'header.component.scss'
})
export class HeaderComponent {
  protected readonly HeaderElement = HeaderElement;

  public constructor(
    private readonly router: Router
  ) {
  }

  private navigate(path: string): void {
    this.router.navigate([path]);
  }
}

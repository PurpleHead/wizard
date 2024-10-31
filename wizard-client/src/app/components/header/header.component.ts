import {Component} from '@angular/core';

interface HeaderItem {
  title: string;
  url: string;
}

@Component({
  selector: 'wizard-header',
  templateUrl: 'header.component.html',
  styleUrl: 'header.component.scss'
})
export class HeaderComponent {

  protected readonly HEADER_ITEMS: HeaderItem[] = [
    {
      title: 'Home',
      url: '/'
    },
    {
      title: 'Scoreboard',
      url: '/scoreboard'
    },

  ];

}

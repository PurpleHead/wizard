import { Component, EventEmitter, Output } from "@angular/core";

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
  @Output()
  public elementClicked = new EventEmitter<HeaderElement>();

  protected readonly HeaderElement = HeaderElement;
}

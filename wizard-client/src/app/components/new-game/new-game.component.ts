import {Component, ElementRef, ViewChild} from '@angular/core';
import {PlayerCreateModel} from '../../shared/model/player-create-model';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'wizard-new-game',
  templateUrl: 'new-game.component.html',
  imports: [
    FormsModule
  ],
  styleUrl: 'new-game.component.scss'
})
export class NewGameComponent {

  @ViewChild('addPlayerInput') addPlayerInput?: ElementRef<HTMLInputElement>;
  protected players: PlayerCreateModel[] = [];

  protected addPlayer(): void {
    const addPlayerInput: HTMLInputElement | undefined = this.addPlayerInput?.nativeElement;
    if (addPlayerInput?.value) {
      this.players.push({
        name: addPlayerInput.value
      });
      addPlayerInput.value = '';
    }
  }

  protected removePlayer(index: number): void {
    this.players.splice(index, 1);
  }
}

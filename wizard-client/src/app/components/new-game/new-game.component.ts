import {Component, ElementRef, inject, ViewChild} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {NgbTypeahead, NgbTypeaheadSelectItemEvent} from '@ng-bootstrap/ng-bootstrap';
import {debounceTime, distinctUntilChanged, filter, map, Observable, OperatorFunction, switchMap} from 'rxjs';
import {GameControllerService, PlayerControllerService, PlayerDto} from '../../generated-sources/wizard-client';

@Component({
  templateUrl: 'new-game.component.html',
  imports: [
    FormsModule,
    NgbTypeahead
  ],
  styleUrl: 'new-game.component.scss'
})
export class NewGameComponent {

  private readonly playerService = inject(PlayerControllerService);
  private readonly gameService = inject(GameControllerService);

  @ViewChild('addPlayerInput') addPlayerInput?: ElementRef<HTMLInputElement>;
  protected players: PlayerDto[] = [];

  protected resultFormatter = (playerDto: PlayerDto): string => playerDto.name;

  protected searchPlayer: OperatorFunction<string, PlayerDto[]> = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(200),
      filter(searchTerm => !!searchTerm),
      distinctUntilChanged(),
      switchMap((searchTerm) =>
        this.playerService.searchPlayers(searchTerm).pipe(
          map(response => response.foundPlayers)
        )
      )
    )

  protected startGame(): void {
    if (this.players.length >= 3) {
      this.gameService.createGame({
        playerIds: this.players.map(p => p.id)
      }).subscribe(console.log);
    }
  }

  protected addPlayer(event: NgbTypeaheadSelectItemEvent<PlayerDto>): void {
    const playerIsNotSelected = this.players.findIndex(p => p.id == event.item.id) === -1;
    if (playerIsNotSelected) {
      this.players.push(event.item);
    }
    if (this.addPlayerInput) {
      this.addPlayerInput.nativeElement.value = '';
    }
    event.preventDefault();
  }

  protected removePlayer(index: number): void {
    this.players.splice(index, 1);
  }
}

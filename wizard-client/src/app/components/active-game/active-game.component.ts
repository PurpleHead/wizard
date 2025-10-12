import {Component, inject, OnInit} from '@angular/core';
import {BlockOfTruthComponent} from './block-of-truth/block-of-truth.component';
import {ActivatedRoute} from '@angular/router';
import {PathParam} from '../../shared/types/path-param.enum';
import {GameControllerService} from '../../generated-sources/wizard-client';

@Component({
  templateUrl: 'active-game.component.html',
  imports: [
    BlockOfTruthComponent
  ],
  styleUrl: 'active-game.component.scss'
})
export class ActiveGameComponent implements OnInit {

  private readonly activatedRoute = inject(ActivatedRoute);
  private readonly gameService = inject(GameControllerService);

  public ngOnInit(): void {
    const gameId = this.activatedRoute.snapshot.paramMap.get(PathParam.GAME_ID);
    if (gameId) {
      this.gameService.getActiveGame(+gameId).subscribe({
        next: console.log,
        error: console.error
      });
    }
  }

}

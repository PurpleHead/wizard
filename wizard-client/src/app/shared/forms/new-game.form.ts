import {FormGroup} from '@angular/forms';
import {PlayerCreateModel} from '../model/player-create-model';

export interface NewGameFormContent {
  players: PlayerCreateModel
}

export interface NewGameForm extends FormGroup {

}

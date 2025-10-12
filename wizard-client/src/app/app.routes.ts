import {Routes} from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import {NewGameComponent} from './components/new-game/new-game.component';
import {ActiveGameComponent} from './components/active-game/active-game.component';
import {PathParam} from './shared/types/path-param.enum';

export const routes: Routes = [
  {
    path: 'new-game',
    component: NewGameComponent
  },
  {
    path: `active-game/:${PathParam.GAME_ID}`,
    component: ActiveGameComponent
  },
  {
    path: '**',
    component: HomeComponent
  }
];

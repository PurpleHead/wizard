import {Routes} from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import {NewGameComponent} from './components/new-game/new-game.component';

export const routes: Routes = [
  {
    path: 'new-game',
    component: NewGameComponent
  },
  {
    path: '**',
    component: HomeComponent
  }
];

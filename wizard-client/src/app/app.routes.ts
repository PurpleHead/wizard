import { Routes } from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import {GamesComponent} from './components/games/games.component';

export const routes: Routes = [
  {
    path: '**',
    component: HomeComponent
  },
  {
    path: 'games',
    component: GamesComponent
  }
];

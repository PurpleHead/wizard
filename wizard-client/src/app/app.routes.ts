import {Routes} from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import {NewGameComponent} from './components/new-game/new-game.component';
import {ActiveGameComponent} from './components/active-game/active-game.component';

export const routes: Routes = [
  {
    path: 'new-game',
    component: NewGameComponent
  },
  {
    path: 'active-game',
    component: ActiveGameComponent
  },
  {
    path: '**',
    component: HomeComponent
  }
];

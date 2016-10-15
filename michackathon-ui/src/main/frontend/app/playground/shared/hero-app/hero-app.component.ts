import {Component, OnInit} from '@angular/core';
import {HeroService} from '../hero.service';
import {Hero} from '../hero';

@Component({
  selector: 'michackathon-hero-app',
  templateUrl: './hero-app.component.html',
  styleUrls: ['./hero-app.component.scss']
})
export class HeroAppComponent implements OnInit {

  title = 'Tour of Heroes';
  heroes: Hero[];
  selectedHero: Hero;

  constructor(private _heroService: HeroService) {
  }

  getHeroes() {
    this._heroService.getHeroes().then(heroes => this.heroes = heroes);
  }

  ngOnInit() {
    this.getHeroes();
  }

  onSelect(hero: Hero) {
    this.selectedHero = hero;
  }

}

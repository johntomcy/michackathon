import {Component, OnInit, Input} from '@angular/core';
import {Hero} from '../hero';

@Component({
  selector: 'michackathon-hero-detail',
  templateUrl: './hero-detail.component.html',
  styleUrls: ['./hero-detail.component.scss']
})
export class HeroDetailComponent implements OnInit {

  @Input()
  hero: Hero;

  constructor() {
  }

  ngOnInit() {
  }

}

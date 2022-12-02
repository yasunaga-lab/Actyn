import {Component, OnInit} from '@angular/core';
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-lan-map',
  templateUrl: './lan-map.component.html',
  styleUrls: ['./lan-map.component.css']
})
export class LanMapComponent implements OnInit {

  constructor(title: Title) {
    title.setTitle('Actyn - Lan map');
  }

  ngOnInit(): void {
  }

}

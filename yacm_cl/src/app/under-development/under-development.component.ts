import {Component, OnInit} from '@angular/core';
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-under-development',
  templateUrl: './under-development.component.html',
  styleUrls: ['./under-development.component.css']
})
export class UnderDevelopmentComponent implements OnInit {

  constructor(title: Title) {
    title.setTitle('Actyn - UD');
  }

  ngOnInit(): void {
  }

}

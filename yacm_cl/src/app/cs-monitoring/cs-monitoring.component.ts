import {Component, OnInit} from '@angular/core';
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-cs-monitoring',
  templateUrl: './cs-monitoring.component.html',
  styleUrls: ['./cs-monitoring.component.css']
})
export class CsMonitoringComponent implements OnInit {

  constructor(title: Title) {
    title.setTitle('Actyn - CS Monitoring');
  }

  ngOnInit(): void {
  }

}

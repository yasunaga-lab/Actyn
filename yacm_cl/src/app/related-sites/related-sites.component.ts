import {Component, OnInit} from '@angular/core';
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-related-sites',
  templateUrl: './related-sites.component.html',
  styleUrls: ['./related-sites.component.css']
})
export class RelatedSitesComponent implements OnInit {

  constructor(title: Title) {
    title.setTitle('Actyn - Related sites');
  }

  ngOnInit(): void {
  }

}

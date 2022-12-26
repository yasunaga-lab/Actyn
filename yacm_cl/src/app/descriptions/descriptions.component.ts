import {Component, OnInit} from '@angular/core';
import {Clipboard} from "@angular/cdk/clipboard";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-descriptions',
  templateUrl: './descriptions.component.html',
  styleUrls: ['./descriptions.component.css']
})
export class DescriptionsComponent implements OnInit {
  yasunaga_ics = "https://calendar.google.com/calendar/ical/tacyas%40yasunaga-lab.bio.kyutech.ac.jp/public/basic.ics";
  morimoto_ics = "https://calendar.google.com/calendar/ical/yvm001%40yasunaga-lab.bio.kyutech.ac.jp/public/basic.ics";

  clipped_yasu = false;
  clipped_mori = false;

  constructor(private clipboard: Clipboard, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.route.fragment.subscribe(f => {
      const element = document.querySelector("#" + f)
      if (element) element.scrollIntoView()
    })
  }

  copyClipboard(str: string, marker: string) {
    this.clipboard.copy(str);
    if (marker == 'yasu') {
      this.clipped_yasu = true;
      setTimeout(() => this.clipped_yasu = false, 1000);
    }
    if (marker == 'mori') {
      this.clipped_mori = true;
      setTimeout(() => this.clipped_mori = false, 1000);
    }

  }

}

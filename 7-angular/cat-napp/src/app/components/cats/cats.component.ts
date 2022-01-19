import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cats',
  templateUrl: './cats.component.html',
  styleUrls: ['./cats.component.css']
})
export class CatsComponent implements OnInit {
  title = "Cats";
  cat = "Fluffy";
  constructor() { }

  ngOnInit(): void {
  }

}

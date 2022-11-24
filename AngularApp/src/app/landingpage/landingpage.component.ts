import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-landingpage',
  templateUrl: './landingpage.component.html',
  styleUrls: ['./landingpage.component.css']
})
export class LandingpageComponent implements OnInit {

  landingpage ={
    title: 'Welcome to Zkybe!',
    image: 'assets/img/Background.jpg'
  }

  constructor() { }

  ngOnInit(): void {
  }

}

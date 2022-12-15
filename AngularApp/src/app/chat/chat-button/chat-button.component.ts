import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-chat-button',
  templateUrl: './chat-button.component.html',
  styleUrls: ['./chat-button.component.css']
})
export class ChatButtonComponent implements OnInit {
  @Input()
  icon_name: string;

  constructor() { }

  ngOnInit(): void {
  }

}

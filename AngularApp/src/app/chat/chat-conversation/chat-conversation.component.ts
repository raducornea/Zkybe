import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-chat-conversation',
  templateUrl: './chat-conversation.component.html',
  styleUrls: ['./chat-conversation.component.css']
})

export class ChatConversationComponent implements OnInit {
  textValue: string = "";

  onKey(event: any){
    this.textValue = event.target.value;
  }

  constructor() { }
  ngOnInit(): void {
  }
}

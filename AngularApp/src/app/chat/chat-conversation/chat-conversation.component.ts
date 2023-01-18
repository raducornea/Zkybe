import { Component, OnInit } from '@angular/core';
import { OidcSecurityService } from 'angular-auth-oidc-client';
import { ChatService } from "../../services/websocket.service";


@Component({
  selector: 'app-chat-conversation',
  templateUrl: './chat-conversation.component.html',
  styleUrls: ['./chat-conversation.component.css'],
  providers: [ChatService]
})

export class ChatConversationComponent implements OnInit {
  messages: string[] = [];
  newMessage = '';

  constructor(private chatService: ChatService, private _oidcSecurityService: OidcSecurityService) {}
  
  ngOnInit() {
    // extract user id from client
    this._oidcSecurityService.getAccessToken().subscribe(token => console.log(token));

    this.chatService.connect(2);
    this.chatService.getMessages().subscribe(message => {
      this.messages.push(message);
    });
  }

  // for emoji button / send button
  onKey(event: any){
    this.newMessage = event.target.value;
  }

  // send functionality for the button
  sendMessage() {
    this.chatService.sendMessage(this.newMessage);
    this.newMessage = '';
  }
}

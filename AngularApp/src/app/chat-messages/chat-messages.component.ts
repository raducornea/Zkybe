// import { Component, OnInit } from '@angular/core';
// import { MatAccordion } from '@angular/material';
// import { Observable, scan } from 'rxjs';
// import { webSocket } from 'rxjs/webSocket';

// @Component({
//   selector: 'app-chat-messages',
//   templateUrl: './chat-messages.component.html',
//   styleUrls: ['./chat-messages.component.css']
// })
// export class ChatMessagesComponent implements OnInit {

//   socket$ = webSocket<string>('ws://localhost:8091/ws');
//   messages$: Observable<string[]>;
//   msg = "";

//   // id-ul conversatiei este o tupla, (a, b) fiind tot una cu (b, a)
//   conversationId: [number, number] = [-1, -1];

//   constructor() { 
//     this.messages$ = new Observable<string[]>(observer => {
//       this.socket$.subscribe(
//         // mesage is of type Object now, so we need to extract the string
//         message => {
//           const messageObject = JSON.stringify(message);
//           const jsonObject = JSON.parse(messageObject);
//           const messageString = jsonObject["echo_message"];

//           console.log("received message:" + messageString);
//           observer.next([messageString]);
//         },
//         error => observer.error(error),
//         () => observer.complete()
//       );
//     });
//   }

//   ngOnInit(): void {
//   }

//   sendMessage() {
//     this.socket$.next(this.msg);
//     console.log("ye");
//     this.msg = "";
//   }
// }

import { Component, OnInit } from '@angular/core';
import { ChatService } from "../services/websocket.service";

@Component({
    selector: 'app-chat-messages',
    templateUrl: './chat-messages.component.html',
    styleUrls: ['./chat-messages.component.css'],
    providers: [ChatService]
})
export class ChatMessagesComponent implements OnInit {
  messages: string[] = [];
  newMessage = '';

  constructor(private chatService: ChatService) {}

  ngOnInit() {
    this.chatService.getMessages().subscribe(message => {
      this.messages.push(message);
    });
  }

  sendMessage() {
    this.chatService.sendMessage(this.newMessage);
    this.newMessage = '';
  }
}

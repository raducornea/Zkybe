import { Component, OnInit } from '@angular/core';
import { MatAccordion } from '@angular/material';
import { Observable, scan } from 'rxjs';
import { webSocket } from 'rxjs/webSocket';

@Component({
  selector: 'app-chat-messages',
  templateUrl: './chat-messages.component.html',
  styleUrls: ['./chat-messages.component.css']
})
export class ChatMessagesComponent implements OnInit {

  socket$ = webSocket<string>('ws://localhost:8091');
  messages$: Observable<string[]>;
  msg = "";

  // id-ul conversatiei este o tupla, (a, b) fiind tot una cu (b, a)
  conversationId: [number, number] = [-1, -1];

  constructor() { 
    this.messages$ = new Observable<string[]>(observer => {
      this.socket$.subscribe(
        message => {
          console.log("received message:" + message);
          observer.next([message]);
        },
        error => observer.error(error),
        () => observer.complete()
      );
    });
  }

  ngOnInit(): void {
  }

  sendMessage() {
    this.socket$.next(this.msg);
    console.log("ye");
    this.msg = "";
  }
}

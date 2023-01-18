import { Component, Injectable, OnInit } from '@angular/core';
import { webSocket, WebSocketSubject } from 'rxjs/webSocket';

@Injectable()
export class ChatService {
  private socket$: WebSocketSubject<string>;

  // constructor() {
  //   this.socket$ = webSocket('ws://localhost:8091/ws');
  // }
  connect(roomId: number) {
    this.socket$ = webSocket(`ws://localhost:8091/ws/${roomId}`);
  }

  sendMessage(message: string) {
    this.socket$.next(message);
  }

  getMessages() {
    return this.socket$.asObservable();
  }
}
import { Component, OnInit } from '@angular/core';


export interface Tile {
  color: string;
  cols: number;
  rows: number;
  text: string;
  hasImage?: boolean;
  imageUrl?: string;
}


@Component({
  selector: 'app-chat-conversation',
  templateUrl: './chat-conversation.component.html',
  styleUrls: ['./chat-conversation.component.css']
})
export class ChatConversationComponent implements OnInit {

  image: string = "assets/happy-stickman.png"
  name: string = "Conversation Title"

  tiles: Tile[] = [
    {text: 'Image', cols: 1, rows: 1, color: 'lightpink', imageUrl: this.image, hasImage: true},
    {text: 'Conversation Title', cols: 5, rows: 1, color: 'lightgreen'},
    {text: 'Icons', cols: 2, rows: 1, color: '#DDBDF1'},
    {text: 'Text', cols: 8, rows: 8, color: 'lightblue'},
    {text: 'Other Icons', cols: 2, rows: 1, color: 'orange'},
    {text: 'Text Message', cols: 5, rows: 1, color: 'pink'},
    {text: 'Send Button', cols: 1, rows: 1, color: 'yellow'},
  ];

  constructor() { }

  ngOnInit(): void {
  }

}

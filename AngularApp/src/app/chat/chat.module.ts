import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ChatRoutingModule } from './chat-routing.module';
import { ChatInformationComponent } from './chat-information/chat-information.component';
import { ChatConversationComponent } from './chat-conversation/chat-conversation.component';


@NgModule({
  declarations: [
    ChatInformationComponent,
    ChatConversationComponent
  ],
  imports: [
    CommonModule,
    ChatRoutingModule
  ]
})
export class ChatModule { }

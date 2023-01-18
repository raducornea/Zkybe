import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ChatConversationComponent } from './chat-conversation/chat-conversation.component';
import { ChatInformationComponent } from './chat-information/chat-information.component';

const routes: Routes = [
    // localhost:4200/chat/
    { 
      path: '', component: ChatInformationComponent, pathMatch: 'full' 
    },
    // localhost:4200/chat/{id}
    { 
      path: ':id', component: ChatConversationComponent
    },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ChatRoutingModule { }

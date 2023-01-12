import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ChatConversationComponent } from './chat/chat-conversation/chat-conversation.component';
import { ChatInformationComponent } from './chat/chat-information/chat-information.component';
import { LandingpageComponent } from './landingpage/landingpage.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
    // localhost:4200/
    { 
      path: '', component: LandingpageComponent, pathMatch: 'full' 
    },
    // localhost:4200/chat/
    { 
      path: 'chat', component: ChatInformationComponent, pathMatch: 'full' 
    },
    // localhost:4200/chat/{id}
    { 
      path: 'chat/:id', component: ChatConversationComponent
    },
    // localhost:4200/register
    { 
      path: 'register', component: RegisterComponent
    },
    // localhost:4200/profile
    { 
      path: 'profile', component: LandingpageComponent // todo: add profile component
    },
    // localhost:4200/search
    { 
      path: 'search', component: LandingpageComponent // todo: add search component
    },
    // localhost:4200/*
    { 
      path: '**', redirectTo: '' 
    }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


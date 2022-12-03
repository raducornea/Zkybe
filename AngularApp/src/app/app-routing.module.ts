import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ChatConversationComponent } from './chat/chat-conversation/chat-conversation.component';
import { ChatInformationComponent } from './chat/chat-information/chat-information.component';
import { HeaderComponent } from './header/header.component';
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
    // localhost:4200/header
    { 
      path: 'header', component: HeaderComponent
    }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


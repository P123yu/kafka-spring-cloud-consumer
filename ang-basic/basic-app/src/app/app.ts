import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ChildComponent } from "./child-component/child-component";
import { ParentComponent } from "./parent-component/parent-component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ChildComponent, ParentComponent],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected readonly title = signal('basic-app');
}

import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-child-component',
  imports: [],
  templateUrl: './child-component.html',
  styleUrl: './child-component.scss',
})
export class ChildComponent {
  @Input() childMessage: string = ''; // Receives data from parent
  @Output() messageEvent = new EventEmitter<string>(); // Sends events to parent

  sendMessage() {
    this.messageEvent.emit('Hello from the Child Component!');
  }
}

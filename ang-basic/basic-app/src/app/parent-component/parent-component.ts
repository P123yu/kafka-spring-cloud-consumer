import { Component } from '@angular/core';
import { ChildComponent } from '../child-component/child-component';

@Component({
  selector: 'app-parent-component',
  imports: [ChildComponent],
  templateUrl: './parent-component.html',
  styleUrl: './parent-component.scss',
})
export class ParentComponent {
  parentData = 'Hello from Parent!';
  reply = '';

  receiveMessage($event: string) {
    // $event contains the data sent by the child
    this.reply = $event;
  }
}

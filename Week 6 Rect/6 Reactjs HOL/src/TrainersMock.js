import { Trainer } from "./trainer";

export const trainers = [
  new Trainer(1, "Alice", "alice@example.com", "1234567890", "React", ["Hooks", "Redux"]),
  new Trainer(2, "Bob", "bob@example.com", "0987654321", "Angular", ["RxJS", "NgRx"]),
  new Trainer(3, "Charlie", "charlie@example.com", "1122334455", "Vue", ["Vuex", "Composition API"])
];

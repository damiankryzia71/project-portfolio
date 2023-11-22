import { DataTypes } from "sequelize";
import sequelize from "./index.js";

//Define model
const ToDoTask = sequelize.define("ToDoTask", {
    task: {
        type: DataTypes.TEXT,
        allowNull: false
    }
});

await ToDoTask.sync();

export default ToDoTask;
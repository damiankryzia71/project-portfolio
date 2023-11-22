import { DataTypes } from "sequelize";
import sequelize from "./index.js";

//Define model
const WorkTask = sequelize.define("WorkTask", {
    task: {
        type: DataTypes.TEXT,
        allowNull: false
    }
});

await WorkTask.sync();

export default WorkTask;
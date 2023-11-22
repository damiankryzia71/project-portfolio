import express from "express";
import * as routes from "./routes/index.js";

const port = 3000;
const app = express();

app.use(express.static("public"));
app.use(express.urlencoded({ extended: true }));

app.use("/", routes.home);
app.use("/work", routes.work);
app.use("/newToDoTask", routes.newTask);
app.use("/newWorkTask", routes.newWork);

app.listen(port, () => {
    console.log(`App running on port ${port}`)
});
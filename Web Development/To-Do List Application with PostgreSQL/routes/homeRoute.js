import express from "express";
import * as controller from "../controllers/toDoTaskController.js";

const router = express.Router();

router.get("/", controller.getAllTasks);
router.post("/", controller.addTask);
router.delete("/:id", controller.deleteTask);

export default router;
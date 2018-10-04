from datetime import datetime

from luigi import Task, DateIntervalParameter


class BowTask(Task):
    time = DateIntervalParameter(default=datetime.now())

    def output(self):
        pass

    def requires(self):
        pass

    def run(self):
        print(f"BowTask is running ({self.time})")

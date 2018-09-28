import sys

from luigi import Task, DateIntervalParameter

assert sys.version_info >= (3, 6)


class BowTask(Task):
    time = DateIntervalParameter()

    def output(self):
        pass

    def requires(self):
        pass

    def run(self):
        print(f"BowTask is running ({self.time})")

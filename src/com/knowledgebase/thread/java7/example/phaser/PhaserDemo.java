package com.knowledgebase.thread.java7.example.phaser;

import java.util.Date;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * This example is from Java 7 Concurrency CookBook.
 * 
 * <p>
 * This example demonstrates the how we can use phaser in real world please
 * check the inline messages to understand more about this program.
 * </p>
 * <p>
 * How it works. This exercise simulates the realization of an exam that has
 * three exercises. All the students have to finish one exercise before they can
 * start the next one. To implement this synchronization requirement, we use the
 * Phaser class, but you have implemented your own phaser extending the original
 * class to override the onAdvance() method.
 * </p>
 * <p>
 * This method is called by the phaser before making a phase change and before
 * waking up all the threads that were sleeping in the arriveAndAwaitAdvance()
 * method. This method receives as parameters the number of the actual phase,
 * where 0 is the number of the first phase and the number of registered
 * participants. The most useful parameter is the actual phase. If you execute a
 * different operation depending on the actual phase, you have to use an
 * alternative structure (if/else or switch) to select the operation you want to
 * execute. In the example, we used a switch structure to select a different
 * method for each change of phase.
 * </p>
 * <p>
 * The onAdvance() method returns a Boolean value that indicates if the phaser
 * has terminated or not. If the phaser returns a false value, it indicates that
 * it hasn't terminated, so the threads will continue with the execution of
 * other phases. If the phaser returns a true value, then the phaser still wakes
 * up the pending threads, but moves the phaser to the terminated state, so all
 * the future calls to any method of the phaser will return immediately, and the
 * isTerminated() method returns the true value.
 * </p>
 * <p>
 * In the Core class, when you created the MyPhaser object, you didn't specify
 * the number of participants in the phaser. You made a call to the register()
 * method for every Student object created to register a participant in the
 * phaser. This calling doesn't establish a relation between the Student object
 * or the thread that executes it and the phaser. Really, the number of
 * participants in a phaser is only a number. There is no relationship between
 * the phaser and the participants.
 * </p>
 * 
 * @author rachana
 * 
 *         Create a class named MyPhaser and specify that it extends from the
 *         Phaser class.
 */
public class PhaserDemo extends Phaser {
    /**
     * Override the onAdvance() method. According to the value of the phase
     * attribute, we call a different auxiliary method. If the phase is equal to
     * zero, you have to call the studentsArrived() method. If the phase is
     * equal to one, you have to call the finishFirstExercise() method. If the
     * phase is equal to two, you have to call the finishSecondExercise()
     * method, and if the phase is equal to three, you have to call the
     * finishExam() method. Otherwise, we return the true value to indicate that
     * the phaser has terminated.
     */
    public boolean onAdvance(int phase, int registeredParties) {
        switch (phase) {
        case 0:
            return studentsArrived();
        case 1:
            return firstExamFinished();
        case 2:
            return secondExamFinished();
        case 3:
            return examFinished();
        default:
            return true;
        }
    }

    /**
     * Implement the auxiliary method studentsArrived(). It writes two log
     * messages to the console and returns the false value to indicate that the
     * phaser continues with its execution.
     */
    private boolean studentsArrived() {
        System.out
                .printf("Phaser: The exam are going to start. The students are ready.\n");
        System.out.printf("Phaser: We have %d students.\n",
                getRegisteredParties());
        return false;
    }

    /**
     * Implement the auxiliary method finishFirstExercise(). It writes two
     * messages to the console and returns the false value to indicate that the
     * phaser continues with its execution
     * 
     */
    public boolean firstExamFinished() {
        System.out
                .printf("Phaser: All the students have finished the first exercise.\n");
        System.out.printf("Phaser: It's time for the second one.\n");
        return false;
    }

    /**
     * Implement the auxiliary method finishSecondExercise(). It writes two
     * messages to the console and returns the false value to indicate that the
     * phaser continues with its execution.
     * 
     * @return
     */
    public boolean secondExamFinished() {
        System.out
                .printf("Phaser: All the students have finished the second exercise.\n");
        System.out.printf("Phaser: It's time for the third one.\n");
        return false;
    }

    /**
     * Implement the auxiliary method finishExam(). It writes two messages to
     * the console and returns the true value to indicate that the phaser has
     * finished its work.
     */
    public boolean examFinished() {
        System.out.printf("Phaser: All the students have finished the exam.\n");
        System.out.printf("Phaser: Thank you for your time.\n");
        return true;
    }

    /**
     * Implement the main class of the example by creating a class named Main
     * and add the main() method to it.
     * 
     * @param argv
     */
    public static void main(String[] argv) {

        PhaserDemo phaser = new PhaserDemo();
        /**
         * Create five Student objects and register them in the phaser using the
         * register() method.
         */
        Student students[] = new Student[5];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(phaser);
            phaser.register();
        }
        /**
         * Create five threads to run students and start them.
         */
        Thread threads[] = new Thread[students.length];
        for (int i = 0; i < students.length; i++) {
            threads[i] = new Thread(students[i], "Student " + i);
            threads[i].start();
        }
        /**
         * Wait for the finalization of the five threads
         */
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        /**
         * Write a message to show that the phaser is in the termination state
         * using the isTerminated() method.
         */
        System.out.printf("Main: The phaser has finished: %s.\n",
                phaser.isTerminated());

    }

}

/**
 * Create a class named Student and specify that it implements the Runnable
 * interface. This class will simulate the students of the exam.
 * 
 * @author rachana
 * 
 */
class Student implements Runnable {
    /**
     * Declare a Phaser object named phaser.
     */
    PhaserDemo phaser;

    /**
     * Implement the constructor of the class that initializes the Phaser
     * object.
     * 
     * @param phaser
     */
    public Student(PhaserDemo phaser) {
        super();
        this.phaser = phaser;
    }

    /**
     * Implement the run() method that will simulate the realization of the exam
     */
    @Override
    public void run() {
        /**
         * First, the method writes a message in the console to indicate that
         * this student has arrived to the exam and calls the
         * arriveAndAwaitAdvance() method of the phaser to wait for the rest of
         * the threads.
         */
        System.out.printf("%s: Has arrived to do the exam. %s\n", Thread
                .currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();
        /**
         * Then, write a message to the console, call the private doExercise1()
         * method that simulates the realization of the first exercise of the
         * exam, write another message to the console and the
         * arriveAndAwaitAdvance() method of the phaser to wait for the rest of
         * the students to finish the first exercise.
         */
        System.out.printf("%s: Is going to do the first exercise. %s\n", Thread
                .currentThread().getName(), new Date());
        doExercise1();
        /**
         * Implement the same code for second exercise and third execise.
         */
        System.out.printf("%s: Has done the first exercise. %s\n", Thread
                .currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();

        System.out.printf("%s: Is going to do the second exercise. %s\n",
                Thread.currentThread().getName(), new Date());
        doExercise2();
        System.out.printf("%s: Has done the second exercise. %s\n", Thread
                .currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();
        System.out.printf("%s: Is going to do the third exercise. %s\n", Thread
                .currentThread().getName(), new Date());
        doExercise3();
        System.out.printf("%s: Has finished the exam. %s\n", Thread
                .currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();
    }

    /**
     * Implement the auxiliary method doExercise1(). This method puts the thread
     * to sleep for a random period of time.
     */
    private void doExercise1() {
        try {
            long duration = (long) (Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Implement the auxiliary method doExercise2(). This method puts the thread
     * to sleep for a random period of time.
     */
    private void doExercise2() {
        try {
            long duration = (long) (Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Implement the auxiliary method doExercise3(). This method puts the thread
     * to sleep for a random period of time.
     */
    private void doExercise3() {
        try {
            long duration = (long) (Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

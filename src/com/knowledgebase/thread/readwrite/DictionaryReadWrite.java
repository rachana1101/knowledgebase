package com.knowledgebase.thread.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class DictionaryReadWrite {

}

class Dictionary {
    ReentrantReadWriteLock readWritelock = new ReentrantReadWriteLock();
    ReadLock readLock = readWritelock.readLock();
    WriteLock writeLock = readWritelock.writeLock();
    
}
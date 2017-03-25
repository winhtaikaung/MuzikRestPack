package com.win.muzikrestpack.presentation.presenter;


import com.win.muzikrestpack.domain.executor.Executor;
import com.win.muzikrestpack.domain.executor.MainThread;

/**
 * Created by win on 3/25/17.
 */
public abstract class AbstractPresenter {
    protected Executor mExecutor;
    protected MainThread mMainThread;

    public AbstractPresenter(Executor executor, MainThread mainThread) {
        mExecutor = executor;
        mMainThread = mainThread;
    }
}

package com.win.muzikrestpack.presentation.presenters.impl;

import com.win.muzikrestpack.domain.executor.Executor;
import com.win.muzikrestpack.domain.executor.MainThread;
import com.win.muzikrestpack.domain.interactors.GetAllArtistModelInteractor;
import com.win.muzikrestpack.domain.interactors.impl.Artist.GetAllArtistModelInteractorImpl;
import com.win.muzikrestpack.domain.model.ArtistModel;
import com.win.muzikrestpack.domain.repository.ArtistRepository;
import com.win.muzikrestpack.presentation.presenters.AbstractPresenter;
import com.win.muzikrestpack.presentation.presenters.ArtistListPresenter;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by win on 3/26/17.
 */

public class ArtistListPresenterImpl extends AbstractPresenter implements ArtistListPresenter,GetAllArtistModelInteractor.Callback {
    private ArtistListPresenter.View mView;
    private ArtistRepository mArtistRepository;

    /**
     *
     * @param executor
     * @param mainThread
     * @param view
     * @param artistRepository
     */
    public ArtistListPresenterImpl(Executor executor, MainThread mainThread,View view, ArtistRepository artistRepository) {
        super(executor, mainThread);
        mView = view;
        mArtistRepository = artistRepository;

    }


    @Override
    public void getAllArtistModel(String page, String pageSize) {
        GetAllArtistModelInteractor artistModelInteractor = new GetAllArtistModelInteractorImpl(mExecutor,
                mMainThread,mArtistRepository,page,pageSize,this);
        artistModelInteractor.execute();
    }

    @Override
    public void onArtistModelRetrieved(Observable<ArtistModel> artistModel) {
        artistModel.subscribe(new Consumer<ArtistModel>() {
            @Override
            public void accept(ArtistModel artistModel) throws Exception {
                mView.onArtistModelRetrieved(artistModel.getArtists());
            }
        });
    }
}

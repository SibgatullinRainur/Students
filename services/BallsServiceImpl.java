package ATB.services;

import ATB.model.Balls;
import ATB.repositories.BallsRepository;
import ATB.repositories.BallsRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service("ballsService")
public class BallsServiceImpl implements BallsService {
    private BallsRepository ballsRepository;

    @Autowired
    public BallsServiceImpl(BallsRepositoryImpl ballsRepository) {
        this.ballsRepository = ballsRepository;
    }

    @Override
    @Transactional
    public void addBall(Balls balls) {this.ballsRepository.addBall(balls);
    }

    @Override
    @Transactional
    public void updateBall(Balls balls) {
        this.ballsRepository.updateBall(balls);
    }

    @Override
    @Transactional
    public void removeBalls(int id) {
        this.ballsRepository.removeBalls(id);
    }

    @Override
    @Transactional
    public Balls getBallsId(int id) {
        return this.ballsRepository.getBallsId(id);
    }

    @Override
    @Transactional
    public List<Balls> listBalls() {
        return this.ballsRepository.listBalls();
    }

}

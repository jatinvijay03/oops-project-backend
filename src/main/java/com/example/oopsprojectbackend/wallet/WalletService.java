package com.example.oopsprojectbackend.wallet;

import com.example.oopsprojectbackend.cartItem.CartItem;
import com.example.oopsprojectbackend.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class WalletService {

    private final WalletRepository walletRepository;

    @Autowired
    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }


    public Optional<Wallet> getWallet(Long uid){
        return walletRepository.findByUid(uid);
    }

    @Transactional
    public Optional<Wallet> topup(Long uid, String pin, Integer amount){
        Optional<Wallet> wallet = walletRepository.checkIfExists(uid, pin);
        wallet.get().setAmount(amount);
        if (wallet.isPresent()) {
            return wallet;
        }
        else{
            throw new IllegalStateException("wallet not found");
        }
    }

    @Transactional
    public Optional<Wallet> update(Long uid, Integer amount){
        Optional<Wallet> wallet = walletRepository.findByUid(uid);
        wallet.get().setAmount(amount);
        if (wallet.isPresent()) {
            return wallet;
        }
        else{
            throw new IllegalStateException("wallet not found");
        }
    }

    public void addWallet(Wallet wallet) {
        Optional<Wallet> walleto = walletRepository.findByUid(wallet.getUid());
        if (walleto.isPresent()) {
            throw new IllegalStateException("wallet exists");
        }
        walletRepository.save(wallet);
    }

}

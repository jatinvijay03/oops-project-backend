package com.example.oopsprojectbackend.wallet;

import com.example.oopsprojectbackend.product.Product;
import com.example.oopsprojectbackend.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WalletController {

    private final WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @RequestMapping(path = "oops/api/wallet/{uid}")
    @CrossOrigin("http://localhost:3000/")
    public Optional<Wallet> getWallet(@PathVariable Long uid){return walletService.getWallet(uid);
    }

    @RequestMapping(path = "oops/api/wallet", method = RequestMethod.POST)
    @CrossOrigin("http://localhost:3000/")
    public void addWallet(@RequestBody Wallet wallet) {
        walletService.addWallet(wallet);
    }

    @RequestMapping(path = "oops/api/wallet/topup", method = RequestMethod.POST)
    @CrossOrigin("http://localhost:3000/")
    public Optional<Wallet> topup(@RequestBody Wallet wallet) {
        Optional<Wallet> walleta = walletService.topup(wallet.getUid(), wallet.getPin(), wallet.getAmount());
        return walleta;
    }

    @RequestMapping(path = "oops/api/wallet/update", method = RequestMethod.POST)
    @CrossOrigin("http://localhost:3000/")
    public Optional<Wallet> update(@RequestBody Wallet wallet) {
        Optional<Wallet> walleta = walletService.update(wallet.getUid(), wallet.getAmount());
        return walleta;
    }
}

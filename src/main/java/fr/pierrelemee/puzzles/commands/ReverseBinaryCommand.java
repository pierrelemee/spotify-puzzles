package fr.pierrelemee.puzzles.commands;

import fr.pierrelemee.puzzles.services.BinaryReverser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReverseBinaryCommand extends AbstractCommand {

    @Autowired
    protected BinaryReverser reverser;

    @Override
    public String getName() {
        return "reversebinary";
    }

    @Override
    public void execute() throws Exception {
        this.out.println(this.reverser.reverseBinary(this.nextLong()));
    }
}

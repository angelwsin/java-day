package com.service.schedule.cmd;

import java.util.List;

import com.service.schedule.Command;

public interface CommandMapper {
    
    
     public  void updateCmd(Command command);
     
     
     public List<Command> cmdList(Command command);
     
     
     public  void insertCmd(Command command);

}

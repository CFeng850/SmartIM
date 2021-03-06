/*
 * Copyright 2014-2017 ieclipse.cn.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.ieclipse.smartim.model.impl;

import cn.ieclipse.smartim.model.IContact;
import cn.ieclipse.smartim.model.IMessage;

/**
 * 联系人抽象类
 * 
 * @author Jamling
 * @date 2017年8月26日
 *       
 */
public abstract class AbstractContact implements IContact {
    protected boolean unknown;
    protected boolean newbie;
    protected IMessage lastMessage;
    protected int unread;
    
    public boolean isUnknown() {
        return unknown;
    }
    
    public void setUnknown(boolean unknown) {
        this.unknown = unknown;
    }
    
    public boolean isNewbie() {
        return newbie;
    }
    
    public void setNewbie(boolean newbie) {
        this.newbie = newbie;
    }
    
    public IMessage getLastMessage() {
        return lastMessage;
    }
    
    public void setLastMessage(IMessage lastMessage) {
        this.lastMessage = lastMessage;
    }
    
    public int getUnread() {
        return unread;
    }
    
    public void setUnread(int unread) {
        this.unread = unread;
    }
    
    public void clearUnRead() {
        this.unread = 0;
    }
    
    public void increaceUnRead() {
        this.unread += 1;
    }
    
    public int compareTo(AbstractContact that) {
        int ret = 0;
        if (this.lastMessage != null) {
            if (that.lastMessage != null) {
                IMessage m1 = this.lastMessage;
                IMessage m2 = that.lastMessage;
                long diff = (m2.getTime() - m1.getTime());
                if (diff > 0) {
                    ret = 1;
                }
                else if (diff < 0) {
                    ret = -1;
                }
            }
            else {
                ret = -1;
            }
        }
        else if (that.lastMessage != null) {
            ret = 1;
        }
        
        return ret;
    }
}

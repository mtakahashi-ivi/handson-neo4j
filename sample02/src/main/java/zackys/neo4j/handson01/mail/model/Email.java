package zackys.neo4j.handson01.mail.model;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity(label="Email")
public class Email extends Entity {

    /**
     * デフォルトコンストラクタ
     */
    public Email() {
    }

    /**
     * アプリで使用
     *
     * @param mailId メールID
     * @param title メール表題
     * @param from 送信元
     * @param to 送信先
     */
    public Email(long mailId, String title, User from, Set<User> to) {
        super();
        this.mailId = mailId;
        this.title = title;
        this.from = from;
        this.to.addAll(to);
    }

    // -------------------- //
    // プロパティ

    @Index(unique=true, primary=true)
    @Property
    private long mailId;

    @Property
    private String title;

    // -------------------- //
    // 関係

    @Relationship(type="SENT_BY", direction=Relationship.INCOMING)
    private User from;

    @Relationship(type="TO")
    private Set<User> to = new HashSet<>();



}

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    @Test
    void testEveryBranch(){
        //a->b->v
        RuntimeException e = assertThrows(RuntimeException.class, () -> SILab2.function(null, null));
        assertEquals("Mandatory information missing!", e.getMessage());

        List<User> users = new LinkedList<>();
        users.add(new User("bojana", "bojana21", "bojana@gmail.com"));
        //a->c->e->m->n->o->v
        assertFalse(SILab2.function(new User("bojana", "bojana2", "bojanagmail.com"), users));
        //a->c->e->f->g1->g2->h->i->j->k->g3->g2->l->m->n->p->q1->q2->r->s->v
        assertFalse(SILab2.function(new User("bojana", "$boki2120", "bojana@gmail.com"), users));
        //a->c->e->f->g1->g2->h->j->g3->g2->l->m->n->p->u->v
        assertFalse(SILab2.function(new User("boki", "$ime 2120", "bojana21@gmail.com"), users));
        //a->c->d->e->f->g1->g2->h->i->j->k->g3->g2->l->m->n->p->q1->q2->r->q3->q2->t->u->v
        users.add(new User("bojana", "bojananana21", "bojana@gmail.com"));
        assertFalse(SILab2.function(new User(null, "bojana20", "bojana1@gmail.com"), users));
    }

    @Test
    void multipleCondition(){

        RuntimeException e = assertThrows(RuntimeException.class, () -> SILab2.function(new User(null, null, null), null));
        assertEquals("Mandatory information missing!", e.getMessage());

        e = assertThrows(RuntimeException.class, () -> SILab2.function(new User("bojana", null, null), null));
        assertEquals("Mandatory information missing!", e.getMessage());

        e = assertThrows(RuntimeException.class, () -> SILab2.function(new User("bojana", "!bojanaaaa", null), null));
        assertEquals("Mandatory information missing!", e.getMessage());

        e = assertThrows(RuntimeException.class, () -> SILab2.function(new User("bojana", "!bojanaaaa", "bojana@gmail.com"), null));
        assertNotEquals("Mandatory information missing!", e.getMessage());
    }
}

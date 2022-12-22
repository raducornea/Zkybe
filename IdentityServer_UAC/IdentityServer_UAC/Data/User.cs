using System.ComponentModel.DataAnnotations.Schema;

namespace IdentityServer_UAC.Data
{
    [Table("users")]
    public class User
    {
        public int Id { get; set; }

        public string Nickname { get; set; }

        public string Password { get; set; }

    }
}
